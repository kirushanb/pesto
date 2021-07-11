import React from 'react';
import {StatusBar} from 'expo-status-bar';
import {API_KEY} from './config/api';
import Weather from './components/weather';
import {
    View,
    Text,
    StyleSheet,
    ActivityIndicator
} from 'react-native';

import * as Location from 'expo-location';


export default function App() {

    const [weatherData, setweatherData] = React.useState([]);
    const [isLoading, setLoading] = React.useState(true);
    const [location, setLocation] = React.useState(null);
    const [errorMsg, setErrorMsg] = React.useState(null);

    React.useEffect(() => {

        (async () => {
            let {status} = await Location.requestForegroundPermissionsAsync();
            if (status !== 'granted') {
                setErrorMsg('Permission to access location was denied');
                console.log(errorMsg)
                return;
            }

            let location = await Location.getCurrentPositionAsync({accuracy: Location.Accuracy.High});
            setLocation(location);
            // console.log(location)
            fetchDataCood(location)
        })();


        const fetchDataCood = (location) => {
            fetch(`http://api.openweathermap.org/data/2.5/weather?lat=${location.coords.latitude}&lon=${location.coords.longitude}&units=metric&appid=${API_KEY}`)
                .then((response) => {
                    return response.json()
                })
                .then((data) => {
                    console.log(data)
                    setweatherData(data)
                    setLoading(false)
                })
                .catch(error => {
                    console.error(error);
                });
        }


    }, []);


    return (
        < View
    style = {styles.container} >
        {
            isLoading ? ( < View style = {styles.headerContainer} >
                < Text style = {styles.tempText} > Fetching The Weather < ActivityIndicator color = "black" / > < /Text>
            < /View>) :  <Weather weatherData={weatherData}/ >
        }

        < /View>
)
    ;
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff'
    },
    headerContainer: {
        flex: 1,
        flexDirection: "row",
        alignItems: "center",
        justifyContent: "space-around",
    },
    tempText: {
        fontSize: 20
    },
});