import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from '@angular/router';

interface Type_book {
  id: number;
  type: string;
  
}

@Component({
  selector: 'app-type-book',
  templateUrl: './type-book.component.html',
  styleUrls: ['./type-book.component.css']
})

export class TypeBookComponent implements OnInit{
  public listOfBooksType: Type_book[] = [];
  searchText: string = '';
 filteredlistOfBooksType: Type_book[] = [];
  
  newType_book: Type_book = {
    id: 0,
    type: "",

}

constructor(private http: HttpClient, private router: Router) {
}

ngOnInit(): void {
  this.getAlltype();
}

getAlltype(): void {
  this.http.get<Type_book[]>('http://localhost:8080/type_ouvrage').subscribe(
    (response: Type_book[]) => {
      this.listOfBooksType = response;
      this.filtertype();
    }
  );
}

filtertype() {
  if (this.searchText.trim() === '') {
    this.filteredlistOfBooksType = this.listOfBooksType;
  } else {
    this.filteredlistOfBooksType = this.listOfBooksType.filter(type_book =>
      type_book.id.toString().includes(this.searchText.trim())
    );
  }
}

deleteType_book(type_book: Type_book): void {
  this.http.delete(`http://localhost:8080/type_ouvrage/delete/${type_book.id}`).subscribe(
    (response: any) => {
      this.getAlltype();
    }
  );
}

editType_book(type_book: Type_book): void {
  this.newType_book = {...type_book};
}

submitForm(): void {
  if (this.newType_book.id) {
    const requestPut = {
      id: this.newType_book.id,
      type: this.newType_book.type,
      }
    
    this.http.put('http://localhost:8080/type_ouvrage/update', requestPut).subscribe((response: any) => {
      this.handleFormSubmission();
    });

  } else {
    const requestPost = {
      type: this.newType_book.type
      }

    this.http.post('http://localhost:8080/type_ouvrage', requestPost).subscribe((response: any) => {
      this.handleFormSubmission();
    });
  }
}

private handleFormSubmission(): void {
  this.getAlltype();
  this.resetFormFields();
}

private resetFormFields(): void {
  this.newType_book = {
    id: 0,
    type: ''
    }
  };
}


