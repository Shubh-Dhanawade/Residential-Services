import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



export interface User{
  name: string;
  email: string;
  address: string;
  role:string;
}

@Injectable({
  providedIn: 'root'
})





export class UserServicesService {

  url = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  addUser(data:any){
    return this.http.post(this.url+"/register",data );
  }

  login(data:any){
    return this.http.post(this.url+"/login",data );
  }

  getUserByEmail(email: string): Observable<User> {
    return this.http.get<User>(`${this.url}/api/user/${email}`);
  }

}
