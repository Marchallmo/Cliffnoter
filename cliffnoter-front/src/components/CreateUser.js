import { useState } from "react";
import classes from "./UserPage.module.css";
import Modal from "./Modal";
import Backdrop from "./Backdrop";

function CreateUser(props) {
  const [modalIsOpen, setModal] = useState(false);
  const [secondStageState, setStage] = useState(false);
  function saveHandler() {
    console.log("clicked");
    setModal(true);
  }

  function closeModalHandler() {
    console.log("clickedd");
    setStage(true);
    setModal(false);
  }
  return (
    <div className={classes.card}>
      <h2>{props.text}</h2>
      <div className="actions">
        <button className="btn" onClick={saveHandler}>
          {props.text1}
        </button>
      </div>
      {modalIsOpen && (
        <Modal onCancel={closeModalHandler} onConfirm={closeModalHandler} />
      )}
      {modalIsOpen && <Backdrop onClick={closeModalHandler} />}
      {secondStageState ? <CreateUser text="Пароль" text1="Save"/>  : null}
      
    </div>
  );
}

export default CreateUser;