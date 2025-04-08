import { Component, OnInit } from '@angular/core';
import { Curso } from '../../../Entidades/Curso';
import { WsService } from '../../../Service/ws.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-curso-list',
  imports: [],
  templateUrl: './curso-list.component.html',
  styleUrl: './curso-list.component.css'
})
export class CursoListComponent implements OnInit{

  constructor(private service : WsService , private router : Router){}

  ngOnInit(): void {
    this.listar();
  }

  curso !: Curso[];
  course : Curso = new Curso();
  
  listar(){
    this.service.listCurso().subscribe(
      {
        next : data =>{
          console.table(data);
          this.curso = data;
        },error : err => {
          console.error(JSON.stringify('No hay datos' + JSON.stringify(err.error.message)));
          Swal.fire({
            title : "Error!",
            text : "No hay datos a listar",
            icon: "error",
            confirmButtonText:"OK"
          });
        }
      }
    )
  }

  crear(){
    this.router.navigate(['create']);
  }

  eliminar(course : Curso){
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: "btn btn-success",
        cancelButton: "btn btn-danger"
      },
      buttonsStyling: false
    });
    swalWithBootstrapButtons.fire({
      title: "¿Seguro?",
      text: "No se puede revertir!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonText: "Si, Borrar!",
      cancelButtonText: "No, Cancelar!",
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.service.deleteCurso(course).subscribe({
          next: data => {
            this.ngOnInit();
            swalWithBootstrapButtons.fire({
              title: "Eliminado!",
              text: "Registro eliminado.",
              icon: "success",
              timer: 1500
            });
          }, error: err => {
            console.log(JSON.stringify(err.error.message));
            swalWithBootstrapButtons.fire({
              title: "Eliminado!",
              text: "Registro eliminado.",
              icon: "success",
              timer: 1500
            });
          }
        });

      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire({
          title: "Cancelado",
          text: "Your file is safe :)",
          icon: "error",
          showConfirmButton: false,
          timer: 1500
        });
      }
    });
  }
}
