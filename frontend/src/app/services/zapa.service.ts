import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Zapa } from '../models/zapa';

@Injectable({
  providedIn: 'root'
})
export class ZapaService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };  
  endpoint:string="http://localhost:8080";
  constructor(private httpClient:HttpClient) { 
  }
    getZapas():Observable<any>{
      return this.httpClient.get<any>(this.endpoint);
    }
    getZapaById(id:number):Observable<Zapa>{
      return this.httpClient.get<Zapa>(this.endpoint+"/"+id);
    }
    addZapa(zapa:Zapa){
      return this.httpClient.post(this.endpoint, JSON.stringify(zapa), this.httpOptions);
    }
    updateZapa(zapa:Zapa, id:number){
      return this.httpClient.put(this.endpoint+"/"+id, JSON.stringify(zapa), this.httpOptions);
    }
    deleteZapaById(id:number){
      return this.httpClient.delete(this.endpoint+"/"+id);
    }
  
}

