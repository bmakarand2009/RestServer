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
        render people as JSON
    }

    //12770508
    def weather() {
        def mystr = """
                      cbfunc({
             "query": {
              "count": 1,
              "created": "2013-01-09T03:44:06Z",
              "lang": "en-US",
              "results": {
               "channel": {
                "title": "Yahoo! Weather - Alpharetta, GA",
                "link": "http://us.rd.yahoo.com/dailynews/rss/weather/Alpharetta__GA/*http://weather.yahoo.com/forecast/USGA0650_f.html",
                "description": "Yahoo! Weather for Alpharetta, GA",
                "language": "en-us",
                "lastBuildDate": "Tue, 08 Jan 2013 9:52 pm EST",
                "ttl": "60",
                "location": {
                 "city": "Alpharetta",
                 "country": "United States",
                 "region": "GA"
                },
                "units": {
                 "distance": "mi",
                 "pressure": "in",
                 "speed": "mph",
                 "temperature": "F"
                },
                "wind": {
                 "chill": "49",
                 "direction": "0",
                 "speed": "0"
                },
                "atmosphere": {
                 "humidity": "66",
                 "pressure": "30.35",
                 "rising": "0",
                 "visibility": "10"
                },
                "astronomy": {
                 "sunrise": "7:41 am",
                 "sunset": "5:43 pm"
                },
                "image": {
                 "title": "Yahoo! Weather",
                 "width": "142",
                 "height": "18",
                 "link": "http://weather.yahoo.com",
                 "url": "http://l.yimg.com/a/i/brand/purplelogo//uh/us/news-wea.gif"
                },
                "item": {
                 "title": "Conditions for Alpharetta, GA at 9:52 pm EST",
                 "lat": "34.02",
                 "long": "-84.25",
                 "link": "http://us.rd.yahoo.com/dailynews/rss/weather/Alpharetta__GA/*http://weather.yahoo.com/forecast/USGA0650_f.html",
                 "pubDate": "Tue, 08 Jan 2013 9:52 pm EST",
                 "condition": {
                  "code": "26",
                  "date": "Tue, 08 Jan 2013 9:52 pm EST",
                  "temp": "49",
                  "text": "Cloudy"
                 },
                 "forecast": [
                  {
                   "code": "26",
                   "date": "8 Jan 2013",
                   "day": "Tue",
                   "high": "48",
                   "low": "44",
                   "text": "Cloudy"
                  },
                  {
                   "code": "26",
                   "date": "9 Jan 2013",
                   "day": "Wed",
                   "high": "58",
                   "low": "50",
                   "text": "Cloudy"
                  }
                 ],
                 "guid": {
                  "isPermaLink": "false",
                  "content": "USGA0650_2013_01_09_7_00_EST"
                 }
                }
               }
              }
             }
            });
        """
         render mystr
    }


}
