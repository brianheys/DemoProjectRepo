import React, {Component, Fragment} from 'react';
import ReactDOM from "react-dom";
import App from './App';

const Index = () => {
  return (
    <Fragment>
      <App />
    </Fragment>
  );
};

ReactDOM.render(<Index />, document.getElementsByClassName("dynamicForm")[0]);
