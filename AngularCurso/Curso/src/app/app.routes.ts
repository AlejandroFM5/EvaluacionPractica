import { Routes } from '@angular/router';
import { CursoListComponent } from './Componentes/Curso/curso-list/curso-list.component';
import { CursoGetComponent } from './Componentes/Curso/curso-get/curso-get.component';

export const routes: Routes = [
    //CURSO
    {path:'list',
        component:CursoListComponent
    },
    {
        path:'create',
        component:CursoGetComponent
    }
];
