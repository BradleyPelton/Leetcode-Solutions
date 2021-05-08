from typing import List


# was a nice try, ran out of time due to cancerous first problem
class Cashier:

    def __init__(self, n: int, discount: int, products: List[int], prices: List[int]):
        self.n = n
        self.discount = discount
        self.products = products
        self.prices = prices
        self.customer_count = 0

    def getBill(self, product: List[int], amount: List[int]) -> float:
        self.customer_count += 1
        total_bill = 0

        #qualified for discount
        if self.customer_count == self.n:
            for i in range(len(product)):
                total_bill += self.prices[product[i]-1] * amount[i]
                # print(total_bill)
            with_discount = total_bill - (self.discount*total_bill)/100
            print(with_discount)
            return(with_discount.format
        #didnt qualify for discount
        else:
            for i in range(len(product)):
                total_bill += self.prices[product[i]-1] * amount[i]
                # print(total_bill)
            print(total_bill)
            return(total_bill)

# Your Cashier object will be instantiated and called as such:
obj = Cashier(3,50,[1,2,3,4,5,6,7],[100,200,300,400,300,200,100])
obj.getBill([1,2],[1,2])
obj.getBill([3,7],[10,10])
obj.getBill([1,2,3,4,5,6,7],[1,1,1,1,1,1,1])