# DigiCurrency-Checker

This is a simple spring boot app that is intended to be run as a CronJob deployment in Kube. 
Currently, it uses the [Nomics API](https://p.nomics.com/cryptocurrency-bitcoin-api) to query the current prices for a list of digital currencies every minute.


It requires an environment variable:
`nomics_api_key` set to your nomics API key. It is recommended that you set this up through a configmap in the kube namespace running the service. 


@TODO 
1. Get it to check the prices without a web request and just spit the output to the console
2. Make that run as a cronjob deployment in our kube instance
3. Get it to send the results as an update to our Gemfire instance
4. We need to have a postgres instance that stores all the different currencies to check and use Gemfire to cache the current list so we are not always hitting the DB every minutes.
   
Number 5 actually doesn't matter in this service - just the todo's above. 
5. The DB needs to store a mapping of users to currencies and their buy and sell prices (this is a many to many table with the currency, user, buy, sell, and time stamp). This table really only matters to the Rabbit notifier instance and the web app to show users in the web interface the latest prices of their currencies of interest.