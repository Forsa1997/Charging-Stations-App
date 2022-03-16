import { render } from '@testing-library/react';
import { mount } from 'enzyme'
import Nav from './Nav';
import App from '../App'

it('renders', () => {
    const div = document.createElement('div')
    render(<Nav />, div)

})

it('renders a navbar in the App', () => {
    const wrapper = mount(<App />)
    expect(wrapper.find("Nav")).toHaveLength(1);
})

it('has a 2 <Link> elements in the Navbar', () => {
    const wrapper = mount(<App />)
    expect(wrapper.find("Link")).toHaveLength(2);
})
