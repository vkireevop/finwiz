import { useState } from 'react';
import { View } from 'react-native';

import CheckBox from '@react-native-community/checkbox';

const CustomCheckBox = () => {
    const [toggleCheckBox, setToggleCheckBox] = useState(false)
    return (
        <CheckBox 
            disabled={false}
            value={toggleCheckBox}
            onValueChange={(newValue) => setToggleCheckBox(newValue)}
        />
    )
}

export default CustomCheckBox;