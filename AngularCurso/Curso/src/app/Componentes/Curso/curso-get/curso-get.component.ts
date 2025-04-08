import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Curso } from '../../../Entidades/Curso';
import { WsService } from '../../../Service/ws.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-curso-get',
  imports: [FormsModule],
  templateUrl: './curso-get.component.html',
  styleUrl: './curso-get.component.css'
})
export class CursoGetComponent implements OnInit{

  constructor (private router : Router, private service : WsService){}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  course : Curso =  new Curso();

  create(){
    this.service.getCurso(this.course).subscribe({
      next: data => {
        Swal.fire({
          title: "OK",
          text: "Se guardo correctemente ",
          icon: "success",
          timer: 2000,
          showConfirmButton: false
        }); this.router.navigate(['listarClientes']);
      },
      error: err => {
        Swal.fire({
          title: "ERROR!",
          text: "Ocurrio un error al guardar!" + this.course.nombre,
          icon: "error",
          confirmButtonText: "OK"
        });
      }
    })
  }

}
