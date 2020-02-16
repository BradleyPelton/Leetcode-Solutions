class ProductOfNumbers:
    def __init__(self):
        self.num_tuple = tuple()

    def add(self, num: int) -> None:
        self.num_tuple += (num,)

    def getProduct(self, k: int) -> int:
        prod_list = self.num_tuple[-k:]
        prod = 1
        for j in prod_list:
            prod *= j
        return(prod)


# Your ProductOfNumbers object will be instantiated and called as such:
obj = ProductOfNumbers()
obj.add(3)
obj.add(0)
obj.add(2)
obj.add(5)
obj.add(4)
obj.getProduct(2)
obj.getProduct(3)
obj.getProduct(4)
obj.add(8)
obj.getProduct(2)


