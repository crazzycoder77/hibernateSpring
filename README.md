## HibernateCURD

Basic Create Read Update Delete Using Hibernate and MySQL
  
## Built With

* [JAVA](https://www.java.com/en/)
* [MySQL](https://www.mysql.com/)

## Authors

* **Praveen Mishra** - *Initial work* - [crazzycoder77](https://github.com/crazzycoder77)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Project Structure

CalculateCost-> Project Name

-src

-com

  -model

   -Package.java
  -dao

   -PackageDao.java ->Interface

   -PackageDaoImpl

   -PackageDaoImplTest

  -util

   -ConnectionHandler.java   

-db.properties

 

 

 

Create A Table package

-----------------------

TableName:package

-------------------

Fields

-------

packageId varchar PK,

sourcePlace varchar,

destinationPlace varchar,

basicFare double,

noOfDays int,

package_cost double

 

 

 

Record Details

-----------------

package.txt

-----------------

 

989/MAA,Chennai,Mumbai,5000,10

205/DEL,Delhi,Chennai,5000,5

560-KAA,Chennai,Goa,8000,2

989\MLA,Mumbai,Mumbai,5000,10

205/,Delhi,Channai,5000,5

5607-AAA,Kolkata,Goa,8000,2

 

 

From the package.txt file, read the details and calculate the packagecost  for each package,  based  on   the conditions  given   below,  and   then   set   the package cost.

--------------------------

noOfDays discount %

--------------------------

  <=5     0% (No discount)

  >5  and <=8 3%

  >8  and <=10 5%

  >10          7%

  Package Cost = ((Basic fare x number of days)-discount)+GST

 

The package cost should be calculated based on the basic fare and the number ofdays. The discount should be calculated depending on the number of days as givenin the above table and deducted from the calculated package cost.  Finally, a GST of 12% of the calculated package cost got after the discount, should be added to get the final package cost.

 

For example: If a package has a basic fare as Rs.3000 and the number of days as15,   then   the   package   cost   will   be   (3000*15),   which   is   Rs.   45000.00.   Since   thenumber of days is 15, the discount percentage will be 7%. So, the discount will be(45000.0*(7/100)) which is Rs. 3150.00. Now, 12% of GST needs to be added. Sothe GST will be ((45000.0-3150.0)*(12/100)) which is Rs. 5022.00.

 

Therefore, the total cost for this package will be (((3000*15)-3150.0)+5022.0) whichis Rs. 46872.00.

 

After calculating the cost for each package, set the package cost and then store theentire Package object into a list.

 

Validation:The packageId should be validated before calculating the package cost;only if thepackageId is valid, the Package object should be added to the list.

 

The packageId should be in the following format.

1. The packageId should contain exactly 7characters

2. The fourth character must be a forward slash symbol (/)

 

If the packageId is valid, then parse the data and calculate the package cost, else throw   a   user   defined   Exception   “InvalidPackageIdException”  

with   a   message"Invalid Package Id".

 

Note:   This   functionality   is   about   only   reading   the   records   from   the   file,parsing  each record  data,   validating   the  package  Id ,creation  of   Package object and then storing the Package Object into the list and return the list.This functionality does not deal with DB Connectivity.

 

After that insert all the package Object from list to  package table.
