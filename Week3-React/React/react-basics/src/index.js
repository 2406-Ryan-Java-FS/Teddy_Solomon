import React from 'react';
import ReactDOM from 'react-dom/client';
import Intro from './components/intro';
import Actor from './components/actor-info';
import MovieList from './components/movie-list';
import ContactForm from './components/contact-form';
import Counter from './components/counter';
import ActorList from './components/actor-list';
import ActorTable from './components/actor-table';

const elizabeth = {
  name: 'Elizabeth Olsen',
  age: 40,
  worth: 50000000
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Intro />
    <Intro />

    <Actor name='Ryan Reynolds' age='50' worth='650000000' />
    <Actor name='Hugh Jackman' age={55} worth={100000000} />
    <Actor {...elizabeth} />

    <MovieList />
    <ContactForm />
    <Counter />
    {/* This is a comment being interpolated into the JSX. */}
    <ActorList />
    <ActorTable />
  </React.StrictMode>
);
