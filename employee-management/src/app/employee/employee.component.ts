import { Component, OnInit } from '@angular/core';
import { HttpClientService } from '../service/http-client.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees:string[] | any;
  public search: string = "";
  public selectedDevice:boolean = false;
   
  constructor(
    private httpClientService:HttpClientService
  ) { }

  filterPost = '';

  ngOnInit() {
    this.httpClientService.getEmployees().subscribe(
     response =>this.handleSuccessfulResponse(response),
    );
  }

handleSuccessfulResponse(response:any)
{
    this.employees=response;
}

onSearch(search:string){
  this.search = search;
};

onChange(event:boolean) {
  this.selectedDevice = event;
  console.log(event);
};

reloadCurrentPage() {
  window.location.reload();
};

deleteEmployee(employee: any): void {
  this.httpClientService.deleteEmployee(employee)
    .subscribe( data => {
      this.employees = this.employees.filter((u: any) => u !== employee);
    })
};

letEmployee(employee: any): void {
  this.httpClientService.activeEmployee(employee)
        .subscribe( data => {
          alert("Usuario y contraseña creados.");
        });
};

/*editEmployee(employee: any): void {
  this.httpClientService.editEmployee(employee)
    .subscribe( data => {
      this.employees = this.employees.filter((u: any) => u !== employee);
    })
};*/

}
