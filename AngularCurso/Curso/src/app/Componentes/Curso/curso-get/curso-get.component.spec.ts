import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CursoGetComponent } from './curso-get.component';

describe('CursoGetComponent', () => {
  let component: CursoGetComponent;
  let fixture: ComponentFixture<CursoGetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CursoGetComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CursoGetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
