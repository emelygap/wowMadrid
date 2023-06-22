import { Component, ViewChild} from '@angular/core';
import { District, RestApiService, Address, Location } from './rest-api.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Time } from '@angular/common';
import { MatSort } from '@angular/material/sort';


export interface TableElement {

  title: string;
  description: string;
  type: string;
  free: boolean;
  price: string;
  date_start: Date;
  date_end: Date;
  time: Time;
  location_name: string;
  address: Address;

}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent {

  districts: District[] = [];
  selectedDistrict: string= '';

  Data: TableElement[]= [];

  col: string[] = ['title', 'description', 'type', 'free', 'price', 'date_start', 'date_end', 'time', 'location_name', 'district_name']
  dataSource = new MatTableDataSource<TableElement>(this.Data);

  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort!:MatSort;

  constructor(private restApiService: RestApiService) {
    this.loadEvents();
    this.restApiService.getDistricts().subscribe((res) => {
      this.districts = res;
    });
  }

  loadEvents() {
    if (this.selectedDistrict) {
      this.restApiService.getEvents(this.selectedDistrict).subscribe((res) => {
        this.dataSource = new MatTableDataSource<TableElement>(res);
        setTimeout(() => {
          this.dataSource.paginator = this.paginator;
        }, 0);
      });
    } else {
      this.restApiService.getEvents().subscribe((res) => {
        this.dataSource = new MatTableDataSource<TableElement>(res);
        setTimeout(() => {
          this.dataSource.paginator = this.paginator;
        }, 0);
      });
    }
  }

}