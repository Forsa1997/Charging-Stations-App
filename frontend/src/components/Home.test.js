import { render, screen } from '@testing-library/react';
import Home from './Home';
import Enzyme, { mount } from 'enzyme'
import Adapter from '@wojtekmaj/enzyme-adapter-react-17'

Enzyme.configure({ adapter: new Adapter() })

it('has a image', () => {
    const wrapper = mount(<Home />)
    expect(wrapper.find("img")).toHaveLength(1);
})

it('has a list with 3 elements', () => {
    const wrapper = mount(<Home />)
    expect(wrapper.find("li")).toHaveLength(3);
}) 
