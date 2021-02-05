import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-car-row',
  templateUrl: './car-row.component.html',
  styleUrls: ['./car-row.component.css']
})
export class CarRowComponent implements OnInit {
  @Input() cocheparam;
  
  constructor() { }

  ngOnInit(): void {
  }

}
