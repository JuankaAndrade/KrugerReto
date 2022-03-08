import { Injectable } from '@angular/core';
//import * as internal from 'stream';
import { HttpClientService } from '../service/http-client.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  employees:string[] | any;

  constructor(){ 
    }

  authenticate(username: string, password: string) {
      switch(username)
      {
        case "juanka.andrade@gmail.com" :
            if(password === "abc123")
              sessionStorage.setItem('type', "user")
            sessionStorage.setItem('username', username)
            sessionStorage.setItem('id', "1")
            return true;
            break; // break es opcional
        
        case "pedrito@gmail.com" :
            if(password === "abc123")
              sessionStorage.setItem('type', "user")
            sessionStorage.setItem('username', username)
            sessionStorage.setItem('id', "2")
            return true;
            break; // break es opcional
        
        case "admin" :
            if(password === "abc123")
              sessionStorage.setItem('type', "admin")
            sessionStorage.setItem('username', username)
            return true;

        default : 
            return false
      }
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }


}
