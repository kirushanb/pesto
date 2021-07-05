import React from "react";
import { View, Text, StyleSheet } from "react-native";
import { MaterialCommunityIcons } from "@expo/vector-icons";
import PropTypes from "prop-types";
import { weatherConditions } from "../utils/WeatherConditions";

const Weather = (props) => {
  const weather = props.weatherData["weather"][0].main;
  const temperature = props.weatherData.main.temp;
  const location = props.weatherData.name;

  return (
    <View
      style={[
        styles.weatherContainer,
        { backgroundColor: weatherConditions[weather].color },
      ]}
    >
      <View style={styles.headerContainer}>
        <MaterialCommunityIcons
          size={72}
          name={weatherConditions[weather].icon}
          color={"#fff"}
        />
        <Text style={styles.tempText}>{temperature}˚</Text>
       
      </View>
      <View style={styles.headerContainer1}>
          
          
          <Text style={styles.tempText1}>{location}</Text>
        </View>

      <View style={styles.bodyContainer}>
        <Text style={styles.title}>{weatherConditions[weather].title}</Text>
        <Text style={styles.subtitle}>
          {weatherConditions[weather].subtitle}
        </Text>
      </View>
    </View>
  );
};

// Weather.propTypes = {
//   temperature: PropTypes.number.isRequired,
//   weather: PropTypes.string
// };

const styles = StyleSheet.create({
  weatherContainer: {
    flex: 1,
  },
  headerContainer: {
    flex: 1,
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "space-around",
  },
  headerContainer1:{
    marginTop:-60,
    paddingRight: 25,
    flex: 1,
    flexDirection: "row",
    // alignItems: "center",
    justifyContent: "flex-end",
  }
  ,
  tempText: {
    fontSize: 72,
    color: "#fff",
  },
  tempText1:{
    fontSize: 60,
    color: "#fff",
  },
  bodyContainer: {
    flex: 2,
    alignItems: "flex-start",
    justifyContent: "flex-end",
    paddingLeft: 25,
    marginBottom: 40,
  },
  title: {
    fontSize: 60,
    color: "#fff",
  },
  subtitle: {
    fontSize: 24,
    color: "#fff",
  },
});

export default Weather;
