from typing import List
from collections import defaultdict

# Accepted first attempt. Solved in 21 minutes. Not a bad lookins solution either

class contests2020q4.leetcode20201017.Solution:
    def displayTable(self, orders: List[List[str]]) -> List[List[str]]:
        """ """
        unique_food_orders = list(set([order[2] for order in orders]))
        # print(unique_food_orders)

        tables = defaultdict(list)

        for order in orders:
            tables[order[1]].append(order[2])
        # print(tables)

        tables_list = [[key, val] for key, val in tables.items()]
        # print(tables_list)
        tables_list.sort(key=lambda x: int(x[0]))
        # print(tables_list)

        display_table = []
        unique_food_orders.sort()
        first_row = ["Table"] + unique_food_orders
        display_table.append(first_row)

        for table in tables_list:
            row = [table[0]]
            for food in unique_food_orders:
                # print(table[1].count(food))
                row.append(str(table[1].count(food)))
                # print(row)
            display_table.append(row)
        print(display_table)
        return(display_table)












a = contests2020q4.leetcode20201017.Solution()
# a.displayTable(orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]])
# a.displayTable(orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]])
a.displayTable(orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]])