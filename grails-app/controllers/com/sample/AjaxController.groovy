package com.sample
import grails.converters.JSON


class AjaxController {

    def index() {

    }
    def jsonPeople() {
        def myHomeAddress = [
                street: "Old Milton Pkwy",
                city:"Atlanta",
                country:"USA",
                pref: true]

        def myWorkAddress = [
                building:"1",
                street: "Science Park",
                city:"Alpharetta",
                country:"USA"]

        def dave = [
                name: "Rick Johnson",
                address: [myHomeAddress, myWorkAddress]]

        def people = [people:[dave]]
        render(text: people as JSON, contentType: "text/json", encoding: "UTF-8")

//        render people as JSON
    }
    //http://localhost:8080/RestServer/ajax/addPerson
    def save = {
        String firstName = params.firstName
        String lastName = params.lastName
        response.status = 400//Bad Request
        def errorMessage = [
                message : "$firstName-$lastName , Add person is not supported by the system"
        ]
        render errorMessage as JSON

    }

    def htmlPage = {
        def htmlPg = " <div> This is a Sample Div which will get dynamically inserted to <b>demostrate </b> load </div>"
    }

    //12770508
    //select * from weather.forecast where woeid=12770508
    def weather() {
        def cbfunc = params.callback;
        def mystr = """
                     ${cbfunc}({
                         "query": {
                          "count": 1,
                          "created": "2013-01-09T04:39:35Z",
                          "lang": "en-US",
                          "results": {
                           "channel": {
                           "location": {
                             "city": "Alpharetta",
                             "country": "United States",
                             "region": "GA"
                            },
                            "item": {
                             "condition": {
                              "code": "26",
                              "date": "Tue, 08 Jan 2013 10:52 pm EST",
                              "temp": "49",
                              "text": "Cloudy"
                             }
                            }
                           }
                          }
                         }
                        });
        """
//         render mystr.trim();
        render(text: mystr, contentType: "text/json", encoding: "UTF-8")

    }


}
