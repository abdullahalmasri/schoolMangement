import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormControl } from "@angular/forms";
import { MatTableDataSource } from "@angular/material/table";
import { Router } from "@angular/router";
import { AuthService } from "../_services/auth.service";
import { NgbModal, ModalDismissReasons } from "@ng-bootstrap/ng-bootstrap";
import { AddStudentComponent } from "../add-student/add-student.component";
import { MatDialog, MatDialogConfig } from "@angular/material/dialog";

export interface UserDetails {
  id: number;
  firstName: string;
  lastName: string;
  age: number;
  classRightNow: string;
  classesSubjects: ClassesSubjects[];
  dateOfschool: number;
  email: string;
  grade: string;
  photo: string;
  role: string;
}

export interface ClassesSubjects {
  id: number;
  year: number;
  classes: string;
}
@Component({
  selector: "app-home-page",
  templateUrl: "./home-page.component.html",
  styleUrls: ["./home-page.component.css"],
})
export class HomePageComponent implements OnInit {
  [x: string]: any;
  constructor(
    private authService: AuthService,
    private router: Router,
    private dialog: MatDialog,
    private formBuilder: FormBuilder,
    private modalService: NgbModal
  ) {}

  userDetails : UserDetails | undefined;
  dataSource = new MatTableDataSource<any>();
  displayedColumns: string[] = [
    "age",
    "classRightNow",
    "firstname",
    "lastname",
    "email",
    "dateOfschool",
    "role"
  ];

  filter1: string = "";
  filter2: string = "";
  filter3: string = "";

  filter1Options: any[] = ["PRIMARY", "SECONDARY"]; // Replace with your options
  filter2Options: any[] = []; // Replace with your options
  filter3Options: any[] = []; // Replace with your options

  // Data array - replace with your actual data
  data: UserDetails[] = [];

  ngOnInit(): void {
    this.authService.getAllUserDetails().subscribe((da) => {
      
      da.forEach((element: { classesSubjects: any }) => {
        console.log(element);
        
        element.classesSubjects.forEach(
          (e: { classes(classes: any): unknown; year: any }) => {
            console.log(e);
            //new Date(e.year).getFullYear()
            this.filter2Options.push(new Date(e.year).getFullYear());
            this.filter3Options.push(e.classes);
          }
        );
      });
      // console.log((da));
      this.dataSource.data = da;
      // this.dataSource.data.forEach(e=>
      //   {
      //     console.log('ele ',e);
      //   e.push('<button mat-raised-button color="danger" (click)="openDialog()"></button>')});
      // this.dataSource.data.forEach(e=>e.push('<button mat-raised-button color="primary" (click)="openDialog()"></button>'));
      console.log("data source ", this.dataSource.data);
      this.data = da;
    });
    // this.applyFilters(); // Initially apply filters to show filtered data
  }
  

  openDialog(): void {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    this.dialog.open(AddStudentComponent, dialogConfig);
  }

  applyFilters(): void {
    let filteredData = this.data;
    // Apply filters
    if (this.filter1) {
      filteredData = filteredData.filter((item) => item.grade === this.filter1);
    }

    if (this.filter2) {
      filteredData.forEach((item) =>
        item.classesSubjects.find((item1) => {
          console.log(item1.year);
          console.log(
            new Date(item1.year).getFullYear().toString() 
          );
          console.log(this.filter2);
          if(new Date(item1.year).getFullYear().toString() === this.filter2.toString()){
            console.log('yes');
            console.log(item);
            filteredData=Array.of(item);
          }
        })
      );
    }

    if (this.filter3) {
      filteredData = filteredData.filter((item) =>
        item.classesSubjects.filter((item1) => item1.classes === this.filter3)
      );
    }

    // Update the data source
    this.dataSource.data = filteredData;
    console.log(filteredData);
  }

  editRow(element:any){
    this.dialog.openDialogs;
    this.userDetails =element;
    console.log('user ',this.userDetails);
    if(this.userDetails!=null)
    this.authService.updateUserDetails(this.userDetails).subscribe((data)=>{
      console.log(data);
    });
  }

  deleteRow(element:any){
    this.userDetails =element;
    console.log('user ',this.userDetails);
    if(this.userDetails!=null)
    this.authService.removeUser(this.userDetails).subscribe((data)=>{
      console.log(data);
    });

  }
}
