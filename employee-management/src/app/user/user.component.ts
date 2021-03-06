import { Component, OnInit } from '@angular/core';
import { HttpClientService } from '../service/http-client.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  employees:string[] | any;
  id:any;
   
  constructor(
    private httpClientService:HttpClientService
  ) { }

  ngOnInit() {
    this.id = sessionStorage.getItem('id');
    this.httpClientService.getEmployees().subscribe(
     response =>this.handleSuccessfulResponse(response),
    );
    //console.log(this.id);
  }

  handleSuccessfulResponse(response:any)
  {
      this.employees=response;
  }

  deleteEmployee(employee: any): void {
    this.httpClientService.deleteEmployee(employee)
      .subscribe( data => {
        this.employees = this.employees.filter((u: any) => u !== employee);
      })
    };
  
  editEmployee(employee: any): void {
    this.httpClientService.deleteEmployee(employee)
      .subscribe( data => {
        this.employees = this.employees.filter((u: any) => u !== employee);
      })
    };
}