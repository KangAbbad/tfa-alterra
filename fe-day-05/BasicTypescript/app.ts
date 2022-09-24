'use strict'

function startDecorator(): Function {
  return function () {
    console.log("Decorator sebelum class");
  };
}

interface IPerkenalan {
  id: number;
  nama: string;
  status: boolean;
}

class Perkenalan implements IPerkenalan {
  @startDecorator()

  id: number;
  nama: string;
  status: boolean;

  constructor(id: number, nama: string, status: boolean) {
    this.id = id;
    this.nama = nama;
    this.status = status;
  }

  private getInfo(): void {
    console.log(`ID: ${this.id}`);
    console.log(`Nama: ${this.nama}`);
    console.log(`Status: ${this.status}`);
  }

  getNumbers(numbers: number[]): void {
    numbers.forEach((number) => console.log(number));
  }
}

const mySelf = new Perkenalan(1, "kangabbad", true);
mySelf.getNumbers([1, 7, 3, 8]);
