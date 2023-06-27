export function calculateTotal (items, tax) {
  let total = 0;

  if(tax < 0 || tax > 1){
    tax = Math.abs(tax);
  }

  for(let i=0; i<items.length; i++){
    total += items[i].price;
    if(items[i].taxable == true){
      total +=  items[i].price * tax;
    }
  }
  return total;
}

const items = [
  {
    price: 100,
    taxable: false
  },
  {
    price: 50,
    taxable: false
  },
  {
    price: 250,
    taxable: true
  }
]
calculateTotal(items, .0975);