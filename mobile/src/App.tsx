import { useEffect } from 'react';
import { NavigationContainer } from "@react-navigation/native";
import { Provider } from "react-redux"
import AsyncStorage from '@react-native-async-storage/async-storage';

import RootNavigator from './navigations/RootNavigator';

import store from './api/store';

function App(): JSX.Element {

  async function getStorage() {
    const json = await AsyncStorage.getItem('auth');
    if (json != null) {
        return json
    } else {
        return ''
    }
  }

  useEffect(() => {
    console.log(getStorage());
  }, [])

  return (
    <Provider store={store}>
      <NavigationContainer>
        <RootNavigator />
      </NavigationContainer>
    </Provider>
  );
}

export default App;
