import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientRequestsListComponent } from './client-requests-list.component';

describe('ClientRequestsListComponent', () => {
  let component: ClientRequestsListComponent;
  let fixture: ComponentFixture<ClientRequestsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientRequestsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientRequestsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
