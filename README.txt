Step1 : To create Account 
Post ==> http://localhost:8080/accounts/save?owner=Sachin&balance=500
Post ==> http://localhost:8080/accounts/save?owner=Bob&balance=1000

STep2 : Transfer the ammount
Post ==> http://localhost:8080/accounts/transfer
Payload
{
  "accFrom": 1,
  "accTo": 2,
  "amount": 200
}

Step 3 : Get all accounts

GET ==> http://localhost:8080/accounts/getAllAccount