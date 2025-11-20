# Java-SAP-Style-Inventory-System-MIGO-MB51-



A simple Java console-based inventory system inspired by real SAP transactions MIGO (Add Material) and MB51 (Display Material Documents).
This project simulates basic warehouse inventory operations, including adding materials, searching entries, sorting data, and calculating total inventory value.

Features
MIGO – Add Material

-Add a new material entry with:
-Auto-incrementing ID
-Material name
-Quantity
-Delivery date
-Entry is saved to a persistent text file (myfile.txt).

MB51 – Display / Manage Entries

-Show all material entries.
-Search entries by material name.
-Sort entries by material (ASC / DESC).
-Delete an entry by ID.
-Calculate total inventory value.
-Enum-Based Product Price Catalog
-Prices are stored using a Java enum (Prices.java).
-Each product (e.g., BOTTLES, TAGS, PALLETES) has:
-A material code
-A predefined unit price

Inventory cost is calculated from:

-lineCost = amount * unitPrice
-Persistent Storage
-All entries are stored in myfile.txt.
-Data is reloaded every time the program runs.

No database required.
