import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ControlContainer, FormControl, FormGroup, FormGroupDirective, Validators } from '@angular/forms';

@Component({
  selector: 'app-passenger-form',
  templateUrl: './passenger-form.component.html',
  styleUrls: ['./passenger-form.component.scss'],
  viewProviders: [{provide: ControlContainer, useExisting: FormGroupDirective}]
})
export class PassengerFormComponent implements OnInit {
  @Input() isSubmitted!: boolean;
  @Output() onSubmit = new EventEmitter();
  
  passengerForm: FormGroup = new FormGroup({
    id: new FormControl('', [Validators.required, Validators.pattern('^[0-9]*$')]),
    name: new FormControl('', Validators.required),
    city: new FormControl('', Validators.required),
  });

  constructor(public parentFormGroup: FormGroupDirective) { }

  ngOnInit(): void {
    this.passengerForm = this.parentFormGroup.control;
  }

  onSubmitPassenger(): void {
    this.onSubmit.emit();
  }
}
