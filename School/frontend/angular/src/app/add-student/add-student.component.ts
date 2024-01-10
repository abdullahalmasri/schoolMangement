import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogActions, MatDialogClose, MatDialogContent, MatDialogRef, MatDialogTitle } from '@angular/material/dialog';

export class UserForm {
  firstName: string = '';
  lastName: string = '';
  role: string = '';
  email: string = '';
  photo: string = ''; // Assuming you want to store the URL or base64 representation of the photo
  age: number | null = null;
  grade: string = '';
  dateOfSchool: Date | null = null;
  classesSubjects: string[] = [];
  classRightNow: string = '';
}

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css'],
  
})
export class AddStudentComponent implements OnInit {
  userForm!: FormGroup;

  constructor(private fb: FormBuilder,    private dialog: MatDialog
    ) {}

  ngOnInit(): void {
    this.initializeForm();
  }

  private initializeForm(): void {
    this.userForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      role: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      photo: [''],
      age: ['', Validators.required],
      grade: [''],
      dateOfSchool: [''],
      classesSubjects: this.fb.array([]), // You can dynamically add controls to this array if needed
      classRightNow: [''],
    });
  }
  closeModal() {
    this.dialog.closeAll();
  }
  onSubmit(): void {
    // Implement your form submission logic here
    // if (this.userForm.valid) {
      console.log('Form submitted:', this.userForm.value);
      // Call your service to save data, etc.
    // } else {
      // console.log('Form is invalid. Please check the fields.');
    // }
  }


  saveClick(){
    // console.log('object ',this.note);
    // this.noteService.addNote(this.note).subscribe(
      // (savedNote)=>{
        // this.closeModal(savedNote)
      // }
    // )
  }
  // closePopup() { 
    // this.displayStyle = "none"; 
  // } 
}
