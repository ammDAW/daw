import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router} from '@angular/router';
import { CarsService } from '../cars.service';

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.css']
})
export class CarDetailsComponent implements OnInit {

  cocheparam;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private carsService: CarsService 
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id'); //coger el numero final de una url

    this.cocheparam = this.carsService.getCar(id); //acceder al coche en particular
  }

}
