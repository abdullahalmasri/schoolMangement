import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../user';
import { Student } from '../student';
import { UserDetails } from '../home-page/home-page.component';

 const apiServerUrl = environment.apiBaseUrl;

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });



  login(user:User): Observable<any> {
    
    return this.http.post<User>(apiServerUrl + `/token`,
      user,{ headers: this.headers });
  }

  register(student:Student): Observable<any> {
    return this.http.post(apiServerUrl + '/register/save', 
      student
    , httpOptions);
  }

  logout(){}


  getAllUserDetails():Observable<any> {
    return this.http.get(apiServerUrl + '/users');
  }

  saveUserDetails(userDetails:UserDetails):Observable<any> {
    return this.http.post(apiServerUrl + '/userDetails/save', 
      userDetails
    , httpOptions);
  }

  updateUserDetails(userDetails:UserDetails):Observable<any> {
    return this.http.post(apiServerUrl + '/userDetails/update', 
      userDetails
    , httpOptions);
  }

  removeUser(userDetails:UserDetails):Observable<any>{
     return this.http.post(apiServerUrl + `/userDetails/remove`,userDetails,httpOptions);
  }
}
