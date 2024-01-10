import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  public data: any[] | undefined;
  
  pageSize = 10;
  pageIndex = 0;
  

  constructor(){}

  ngOnInit(){
    // this.getLogin();
    // this.getNotes();
  }
  

  
}
