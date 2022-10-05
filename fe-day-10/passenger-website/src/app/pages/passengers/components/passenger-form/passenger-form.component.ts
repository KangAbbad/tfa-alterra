import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormGroup, FormGroupDirective } from '@angular/forms';

@Component({
  selector: 'app-passenger-form',
  templateUrl: './passenger-form.component.html',
  styleUrls: ['./passenger-form.component.css']
})
export class PassengerFormComponent implements OnInit {
  @Input() isSubmitted!: boolean;
  @Output() onSubmit = new EventEmitter();
  
  passengerForm!: FormGroup;

  constructor(private parentFormGroup: FormGroupDirective) { }

  ngOnInit(): void {
    this.passengerForm = this.parentFormGroup.control;
  }

  onSubmitPassenger(): void {
    this.onSubmit.emit();
  }
}
