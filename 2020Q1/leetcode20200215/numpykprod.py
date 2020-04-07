from numpy import array, append
class ProductOfNumbers:

    def __init__(self):
        self.arr = array([])


    def add(self, num: int) -> None:
        self.arr = append(self.arr,num)


    def getProduct(self, k: int) -> int:
        """returns the product of the last k elements"""
        prod_list = self.arr[-k:]
        arrprod = prod_list.prod()
        return(int(prod))



obj = ProductOfNumbers()
obj.add(3)
obj.add(0)
obj.add(2)
obj.add(5)
obj.add(4)
print(vars(obj))
obj.getProduct(2)
obj.getProduct(3)
obj.getProduct(4)
obj.add(8)
obj.getProduct(2)