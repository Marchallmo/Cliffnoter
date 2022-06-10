import UserPageContent from "../components/TextContent";
function UserPage() {
  return (
    <div>
        <UserPageContent text='Имя Пользователя' text1='edit'></UserPageContent>
        <UserPageContent text='Пароль' text1='edit'></UserPageContent>
    </div>
  );
}

export default UserPage;
