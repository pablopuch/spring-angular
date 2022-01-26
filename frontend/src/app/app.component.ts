import { ZapaService } from './services/zapa.service';
import { Component, OnInit } from '@angular/core';
import { Zapa } from './models/zapa';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  zapas:Zapa[]=[];
  zapa:Zapa=new Zapa();
  modalMode="";
  index=0;
  
  constructor(private zapaService:ZapaService){}
  ngOnInit(): void {
    this.getZapas();
  }

  getZapas(){
    this.zapaService.getZapas().subscribe((data)=>{
      
      this.zapas=data.zapas;
      this.zapas.shift();
    },
    (error)=>{console.error(error)})
  }

  newModal(){
    this.modalMode="Add new";
    this.zapa=new Zapa();
  }

  editModal(id:number, index:number){
    this.zapa=this.zapas[index];
    this.index=index;
    this.modalMode="Edit"
    this.zapaService.getZapaById(id).subscribe((data)=>{
      this.zapa=data;
    },
    (error)=>{console.error(error)})
    
  }
  
  deleteZapa(id:number, index:number){
    this.zapaService.deleteZapaById(id).subscribe((data)=>{
      console.log(data);
      data==1?this.zapas.splice(index,1):null;
    },
    (error)=>{console.error(error)})
  }

  addZapa(){
    if(this.modalMode=="Edit"){
    this.zapaService.updateZapa(this.zapa,this.zapa.id).subscribe((data)=>{
      if(data==1){
        this.zapas.splice(this.index, 1, this.zapa);
      }
    },
    (error)=>{console.error(error)})
  }else{
    this.zapaService.addZapa(this.zapa).subscribe((data)=>{
      console.log(data);
      this.zapas.push(<Zapa>data);
    },
    (error)=>{console.error(error)}
    )
  }
  }

}
