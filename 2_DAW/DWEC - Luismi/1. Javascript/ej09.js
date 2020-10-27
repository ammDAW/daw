document.addEventListener("DOMContentLoaded", function(){
    const txtAdd = document.querySelector("#txtAdd") //contenedor de input texto
    const btnAdd = document.querySelector("#btnAdd") //contenedor de boton añadir a lista
    const mylist = document.querySelector("#mylist") //contenedor de lista compra
    
    //dar el foco a la caja input texto
    txtAdd.focus()
    
    //tecla intro
    txtAdd.addEventListener("keyup", function(e){
        if(e && e.key=="Enter"){
            addItemToList(txtAdd, mylist)
        }
    })

    //click del boton "Add to shopping list"
    btnAdd.addEventListener("click", function(){
        addItemToList(txtAdd, mylist)
    })

    //resto de botones
    document.querySelector("#btnSelAll").addEventListener("click", function(){
        //let todosLosLi = mylist.querySelectorAll("li") //coger todos los datos solamente de la lista
        let todosLosLi = document.querySelectorAll("#mylist>li")
        todosLosLi.forEach(function(elemento){
            elemento.classList.add("seleccionado")
        })
    })

    document.querySelector("#btnSelNot").addEventListener("click", function(){
        let todosLosLi = document.querySelectorAll("#mylist>li")
        todosLosLi.forEach(function(elemento){
            elemento.classList.remove("seleccionado")
        })
    })
    document.querySelector("#btnInvSel").addEventListener("click", function(){
        let todosLosLi = document.querySelectorAll("#mylist>li")
        todosLosLi.forEach(function(elemento){
            elemento.classList.toggle("seleccionado") //interruptor que quita la clase si la tiene o se la da si no al tiene
        })
    })
    document.querySelector("#btnMovSel").addEventListener("click", function(){

    })
    document.querySelector("#btnDelSel").addEventListener("click", function(){

    })
})


function addItemToList(txtAdd, mylist){
    //comprobar is hay texto en la caja
    if(txtAdd.value.trim().length){
        //crear un nuevo <li> con el texto de la caja
        let nuevoLi = document.createElement("li") //está 'flotando' en el aire
        nuevoLi.textContent = txtAdd.value.trim()
        //insertarlo en la lista "My shopping list"
        mylist.appendChild(nuevoLi)
        //hacer clickable el nuevo <li>
        nuevoLi.addEventListener("click", function(){
            this.classList.toggle("seleccionado")
        })
        //vaciar caja y poner de nuevo foco en ella
        txtAdd.value=""
        txtAdd.focus()
    }
}