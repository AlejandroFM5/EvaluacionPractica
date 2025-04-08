import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Curso } from '../Entidades/Curso';

@Injectable({
  providedIn: 'root'
})
export class WsService {

  url = "http://localhost:8230/curso";

  constructor(private http : HttpClient) {};
    
    listCurso(){
      return this.http.get<Curso[]>(this.url+'/lista');
    }

    getCurso(course : Curso){
      return this.http.post<Curso>(this.url+'/nuevo',course);
    }

    deleteCurso(course : Curso){
      const headers = new HttpHeaders({'ContentType' : 'aplication/json'});
    return this.http.delete<Curso>(this.url+'/eliminar',{headers, body : course});
    }

}
