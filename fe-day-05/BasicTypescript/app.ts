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

@startDecorator()
class Perkenalan implements IPerkenalan {
  id: number;
  nama: string;
  status: boolean;

  constructor(id: number, nama: string, status: boolean) {
    this.id = id;
    this.nama = nama;
    this.status = status;
  }

  private getId(): number {
    return this.id;
  }

  private getNama(): string {
    return this.nama;
  }

  private getStatus(): boolean {
    return this.status;
  }

  getInfo(): void {
    console.log(`ID: ${this.getId()}`);
    console.log(`Nama: ${this.getNama()}`);
    console.log(`Status: ${this.getStatus()}`);
  }

  getNumbers(numbers: number[]): void {
    numbers.forEach((number) => console.log(number));
  }
}

const mySelf = new Perkenalan(1, "kangabbad", true);
mySelf.getInfo();
mySelf.getNumbers([1, 7, 3, 8]);
