'use strict';
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
function startDecorator() {
    return function () {
        console.log("Decorator sebelum class");
    };
}
var Perkenalan = /** @class */ (function () {
    function Perkenalan(id, nama, status) {
        this.id = id;
        this.nama = nama;
        this.status = status;
    }
    Perkenalan.prototype.getInfo = function () {
        console.log("ID: ".concat(this.id));
        console.log("Nama: ".concat(this.nama));
        console.log("Status: ".concat(this.status));
    };
    Perkenalan.prototype.getNumbers = function (numbers) {
        numbers.forEach(function (number) { return console.log(number); });
    };
    __decorate([
        startDecorator()
    ], Perkenalan.prototype, "id", void 0);
    return Perkenalan;
}());
var mySelf = new Perkenalan(1, "kangabbad", true);
mySelf.getNumbers([1, 7, 3, 8]);
