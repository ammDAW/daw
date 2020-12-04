document.addEventListener("DOMContentLoaded", main);

function main(){
    //Crear un objeto para la comunicación asíncrona con el servidor
    let xhr = new XMLHttpRequest();

    //Definir la función que se va a encargar de vigilar los cambios de estado del propio objeto xhr
    xhr.addEventListener("readystatechange", function(){
        //Preguntar a que estado acaba de cambiar el objeto xhr
        if(this.readyState == 4 && this.status == 200){
            //Todo ha ido bien, debo procesar la respuesta del servidor
            //Recorrer el XML en busca de la información crítica
            let nombresProvincias = Array.from(this.responseXML.getElementsByTagName("provincia"))
            const selectProvincias = document.querySelector("#provincia")
            selectProvincias.innerHTML = "<option>(Listado de provincias)</option>" //añadir un primer option como elemento predeterminado del <select>
            
            nombresProvincias.forEach(element => {
                let codigo = element.firstElementChild.textContent
                let nombre = element.lastElementChild.textContent
                let nuevoOption = document.createElement("option")
                nuevoOption.textContent = nombre
                nuevoOption.value = codigo
                selectProvincias.append(nuevoOption)
            })
            
            //Capturar los cambios que el usuario haga en el <select> de provincias
            selectProvincias.addEventListener("change", function() {
                //this.selectedIndex //número de <option> que está seleccionado
                console.log(this.children[this.selectedIndex].textContent)
                cargaMunicipios(this.value)
                
                //iniciar una segunda llamada AJAX, esta vez pasando un parámetro con el código de la provincia seleccionadaa por el usuario
                
            })
        }
    })

    /*funcion que define la forma de acceso y el recurso al que accederemos
    Adicionalmente, ponemos true para indicar que la comunicación es asíncrona*/
    xhr.open("GET", "cargaProvinciasXML.php")
    xhr.send() //lanzamos al consulta
}

function cargaMunicipios(codProvincia){
    //llamar al segundo PHP y pasarle codProvincia como parámetro "provincia"
    
    //Iniciar una segunda llamada AJAX, esta vez pasando un parámetro con el código de la provincia seleccionada por el usuario
    let xhr2 = new XMLHttpRequest()
    xhr2.addEventListener("readystatechange", function(){
        if(this.readyState == 4 && this.status == 200){
            //procesar la respuesta del servidor: XML --> <OPTIONs> del 2º <SELECT>
            let nombresMunicipios = Array.from(this.responseXML.getElementsByTagName("municipio"))
            const selectMunicipios = document.querySelector("#municipio")
            selectMunicipios.innerHTML="<option>(Listado de municipios)</option>"
            
            nombresMunicipios.forEach(element => {
                let codMunicipio = element.firstElementChild.textContent
                let nomMunicipio = element.lastElementChild.textContent
                let nuevoOption = document.createElement("option")
                nuevoOption.textContent = nomMunicipio
                nuevoOption.value = codMunicipio
                selectMunicipios.append(nuevoOption)
            })
        }
    })
    xhr.open("POST", "cargaMunicipiosXML.php")
    xhr2.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    xhr.send("provincia=" + codProvincia)
}