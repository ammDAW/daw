//servicio
private url = "https://my-json-server.typicode.com/ammDAW/daw/"

constructor(private http: HttpClient) { }

getCars(){
   return this.http.get(this.url + "coches");
 }

//implementar service
export class CatalogoCochesComponent implements OnInit {
  coches;
  loading = false;

  constructor(private carsService: CarsService) { }

  ngOnInit(): void {
    this.loading = true;
    this.carsService.getCars().subscribe(
      (response) => {
        this.coches = response;
        this.loading = false; },
      (error) => {
        console.error('Request failed with error');
        console.error(error);
        this.loading = false; }
    )
  }

//implementar busqueda
<app-car-card *ngFor="let coche of coches"
        [cocheparam]="coche"></app-car-card>
@Input() cocheparam;

//detalles pasar id
<a [routerLink]="['/detalles', cocheparam.id]">DETALLES</a>

objetoCoche;
  constructor(
    private id: ActivatedRoute,
    private carsService: CarsService) { 
  }

  ngOnInit(): void {
    const idCoche = this.id.snapshot.paramMap.get("id"); //recoger el id que viene por ruta 
    this.carsService.getId(idCoche).subscribe(
      (response) => {
        this.objetoCoche = response;
     },
      (error) => {
        console.error(error);
      }  
    );
  }