Problem: Coffee Vending Machine

# Problem Statement: Design a simple coffee vending machine that can make different types of coffee.

Requirements:
What the machine should do:
1. Coffee Types Available:
   - Espresso     (needs: 1 coffee unit, 0 milk, 0 water)             -  Price: ₹40
   - Latte        (needs: 1 coffee unit, 1 milk unit, 1 water unit)   -  Price: ₹60
   - Cappuccino   (needs: 1 coffee unit, 2 milk units, 1 water unit)  -  Price: ₹70

2. Basic Operations:
   - Display available coffee options
   - Make a selected coffee if ingredients are available
   - Show ingredient levels (coffee, milk, water)
   - Refill ingredients

3. Rules:
   - If ingredients are not sufficient, show "Cannot make [coffee name], insufficient [ingredient]"
   - After making coffee, deduct the ingredients used
   - Initial inventory: 10 units of each ingredient



# Sample Flow
Available: Coffee=10, Milk=10, Water=10

User selects: Latte
Output: "Latte prepared! Enjoy your coffee."
Remaining: Coffee=9, Milk=9, Water=9

User selects: Latte (9 more times)
Remaining: Coffee=0, Milk=0, Water=0

User selects: Espresso
Output: "Cannot make Espresso, insufficient Coffee"

Admin refills all ingredients
Remaining: Coffee=10, Milk=10, Water=10