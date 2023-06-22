import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Time } from '@angular/common';

export interface Area{
  id: number;
  street_address: string;
  postal_code: string;
}

export interface District{
  id: number;
  district_name: string;
}

export interface Address{
  id: number;
  area: Area;
  district: District;
}

export interface Location{
  id: number;
  latitude: string;
  longitude: string;
}

export interface Event {
  id: string;
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
  location: Location;
}

@Injectable({
  providedIn: 'root'
})

export class RestApiService {

  
  constructor(private http: HttpClient) { }

  getEvents(district?: string): Observable<Event[]> {
    let api = "http://localhost:5000/events";
    if (district){
      api = `http://localhost:5000/events/district/${district}`;
    }
    return this.http.get<Event[]>(api)
  }

  getDistricts(): Observable<District[]> {
    const api = "http://localhost:5000/districts";
    return this.http.get<District[]>(api);
  }
}
