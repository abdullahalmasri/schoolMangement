import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { User } from "../user";
import { AuthService } from "../_services/auth.service";
import { TokenStorageService } from "../_services/token-storage.service";
import { ViewEncapsulation } from "@angular/core";
import { FormBuilder, FormControl, Validators } from "@angular/forms";
import { Student } from "../student";

@Component({
  selector: "app-login-component",
  templateUrl: "./login-component.component.html",
  styleUrls: ["./login-component.component.css"],
  encapsulation: ViewEncapsulation.None,
})
export class LoginComponentComponent implements OnInit {
  username = new FormControl("");
  password = new FormControl();
  name = new FormControl("");
  role = new FormControl();
  confirmPassword = new FormControl("");

  loginForm = this.formBuilder.group({
    username: "",
    password: 0,
  });

  signForm = this.formBuilder.group({
    name:"",
    username: "",
    password: 0,
    role:0
  });
  color = "primary";
  isLoggedIn = false;
  isLoginFailed = false;
  isLoginOpen = false;
  errorMessage = "";
  roles: string[] = [];
  isVisible: boolean = false;
  time_to_show_login = 400;
  time_to_hidden_login = 200;
  user: User|any;
  student:Student|any;
  constructor(
    private authService: AuthService,
    private tokenStorage: TokenStorageService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {}
  //[Validators.required,Validators.pattern(
  //'^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$'
  //)]
  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      // this.roles = this.tokenStorage.getUser().roles;
    }
  }
  onRegister(){
    this.signForm;
    let roleNumber =null;
    console.log(this.role.value);
    if(this.role.value=="Student"){
      roleNumber=0;
    }else{
      roleNumber=1;
    }

    this.signForm=this.formBuilder.group({
      name:[this.name.value,Validators.required],
      username:[this.username.value, Validators.required],
      password:[Number(this.password.value),Validators.required],
      role:[roleNumber,Validators.required]
    })
    this.student=this.signForm.value;
    console.log(this.student);
    this.authService.register(this.student).subscribe(
      (data) => {
        console.log("the data here is ", data);
      },
      (err) => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }
  onSubmit() {
  // let user: User | undefined;

    // let user: User | undefined;
    // this.username=new FormControl('username')|;;
    // this.password=new FormControl('password');;
    // this.user.username = new FormControl('');
    this.loginForm;
    this.loginForm=this.formBuilder.group({
      username:[this.username.value, Validators.required],
      password:[Number(this.password.value),Validators.required]
    })
    // this.user = this.User;
    // console.log(this.loginForm);
    // console.log(this.username.value);
    // console.log(this.password.value);
    this.user=this.loginForm.value;
    console.log(this.user);

    this.authService.login(this.user).subscribe(
      (data) => {
        console.log("the data here is ", data);
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        // this.roles = this.tokenStorage.getUser().roles;
        this.reloadPage();
      },
      (err) => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
    // if(!this.loginForm.valid){
    //   return;
    // }
    // localStorage.setItem('user',this.loginForm.value)
    // this.router.navigate(['/pageData'])
  }
  reloadPage(): void {
    this.router.navigate(["/home"]);
  }
  loginModel() {
    this.isLoginOpen = true;
    this.isVisible = true;
    console.log("yes");
    const div = document.querySelector(".cont_forms");
    const divip = document.getElementById("cont_form_login");

    if (divip)
      if (div) {
        const divup = document.getElementById("cont_form_sign_up");
        if (divup) {
          div.className = "cont_forms cont_forms_active_login";
          divip.style.opacity = "1";
          divip.style.display = "block";
          divup.style.display = "none";
          divup.style.opacity = "0";
        }
      }
  }
  backDefault() {
    console.log("noooooooooo");
    const div = document.querySelector(".cont_forms");
    const divip = document.getElementById("cont_form_login");
    const divup = document.getElementById("cont_form_sign_up");
    if (divip)
      if (div) {
        if (divup) div.className = "cont_forms";
        divip.style.opacity = "0";
        divip.style.display = "none";
      }
  }

  sigupModel() {
    this.isLoginOpen = true;
    this.isVisible = true;
    console.log("yes");
    const div = document.querySelector(".cont_forms");
    const divip = document.getElementById("cont_form_sign_up");
    const divup = document.getElementById("cont_form_login");

    if (divip)
      if (div) {
        if (divup) {
          div.className = "cont_forms cont_forms_active_sign_up";
          divip.style.opacity = "1";
          divip.style.display = "block";
          divup.style.display = "none";
          divup.style.opacity = "0";
        }
      }
  }
  backDefaultsign() {
    console.log("noooooooooo");
    const div = document.querySelector(".cont_forms");
    const divip = document.getElementById("cont_form_sign_up");
    if (divip)
      if (div) {
        div.className = "cont_forms";
        divip.style.opacity = "0";
        divip.style.display = "none";
      }
  }
}
