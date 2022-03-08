import { formatPercent } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { HttpClientService } from '../service/http-client.service';
import { FormControl, FormGroup, Validators } from '@angular/forms'
import { ActivatedRoute } from '@angular/router'

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {
   
  id: any;
  //user: Employee = Employee.arguments();
  employees:string[] | any;
  filteredEmployee: any;
  

  editEmployee = new FormGroup({
    nombres: new FormControl(''),
    apellidos: new FormControl(''),
    cedula: new FormControl(''), 
    correo: new FormControl(''),
  }) 

  constructor(
    private router:ActivatedRoute, private httpClientService:HttpClientService){ 
    }

  ngOnInit() {
    this.httpClientService.getEmployees().subscribe(
     response =>this.handleSuccessfulResponse(response),
    );
    
  }

  handleSuccessfulResponse(response:any)
  {
      this.employees=response;
      this.updateEmployee()
  }

  updateEmployee(): void {
    this.id = this.router.snapshot.params['id'];
    let selectedOpt = this.employees.find((opt: { empId: any; }) => opt.empId == this.id);
    this.filteredEmployee = selectedOpt; 
    return this.filteredEmployee;
  };

}
