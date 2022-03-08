import { Pipe, PipeTransform } from '@angular/core';
import { Employee } from '../service/http-client.service';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(employee: Employee[], search: string='', selectedDevice: boolean): Employee[] {
    
    //const filteredEmployee = employee.filter( employee => employee.vaccinated = selectedDevice)
    //const filteredEmployee = employee.filter( employee => employee.nombres.includes(search) ); 
    const filteredEmployee = employee.filter( employee => employee.vaccine[0][1].includes(search))  
    /*const resultadoPost = [];
    for(const post of value){
      if(post.title.indexOf(args) > -1){
        resultadoPost.push(post);
        console.log('Sip');
      };
    };*/
    console.log(employee);
    return filteredEmployee.filter(employee => employee.vaccinated == selectedDevice);
  }

}
